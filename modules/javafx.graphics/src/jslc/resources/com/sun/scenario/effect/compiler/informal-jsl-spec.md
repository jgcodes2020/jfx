# The Unofficial Java Shading Language (JSL) Specification

This spec was created to document JSL, as far as I can deduce from existing shaders and grammar files.

# Types

JSL supports three basic types:

- `int` for integers
- `bool` for booleans,
- `float` for floating-point numbers.

## Vectors

There are vectors of each type containing 2 to 4 components. For example, a 3D float vector can be specified as `float3`
. For some reason, JSL lacks support for matrices, but I hope to add that soon.

Vectors can be created in multiple different ways, as shown in the following example:

```jsl
int3 normal = normalize(int3(16, 10, 14))
int vertical = normal.y
int2 horizontal = normal.xz
```

This syntax is almost like GLSL's. To construct a vector from its initial components, one may use the vector
constructor, similarly to the above example.

To access the vector's components, use `x`, `y`, `z`, and `w` to access the first, second, third and fourth components
respectively. These are also aliased as `r`, `g`, `b` and `a` to ease working with colours.

One can actually combine these to create a new vector with the specified components as the new vector's components.

As an example, given `float3 thing`, `thing.xz` creates a `float2` whose x-component is equal to `thing.x` and whose
y-component is equal to `thing.z`.

## Samplers

There are 3 sampler types in JSL: `sampler`, `lsampler`, and `fsampler`. These sampler types allow one to pull data from
a texture.

TODO: add more info about samplers.

# Operators

All the basic arithmetic operators are present for `int` and `float`. These are:

- `+` (add)
- `-` (subtract)
- `*` (multiply)
- `/` (divide)

When used with vectors, `+` and `-` will do exactly what you might expect: add or subtract vectors. You cannot use
`*` or `/` with two vectors, however, you *can* multiply or divide vectors by scalars.

That is: you can multiply `float`
and `float2` together, you can divide `float2` by `float` but only in that order, same for `int` vectors.

## Functions

JSL, like other shading languages, provides built-in functions for various vector and sampler operations. Here are the
ones that I know of to date:

Vector function | Description
-------- | -----------
`dot(a, b)` | Takes the dot product of vectors `a` and `b`.
`cross(a, b)` | Takes the cross product of vectors `a` and `b`. Both must be 3D vectors.
`normalize(a)` | Normalizes vector `a`.

Sampler function | Description
--- | ---
`sample(sampler, position`

# Implicit globals
JSL provides implicit globals.
## Pixel/Fragment shaders
The desired color can be assigned to the implicit global variable `color`.