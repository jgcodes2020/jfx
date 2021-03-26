package com.sun.javafx.sg.prism;

import javafx.util.Pair;

import java.util.*;

/**
 * A map of shader parameters. These map to GLSL {@code uniform} and global HLSL variables.
 *
 * @implNote The current implementation uses indexed maps.
 */
public class ShaderParamMap {
    // Maps
    private final Map<String, Integer> indexingMap;
    private final List<Class<?>> clazzList;
    private final List<Object> varList;
    // Constants

    /**
     * I hope to use an API like GL's uniform4f. Hence why I only allow assigning float, int, and vectors thereof.
     */
    private static final Map<Class<?>, Object> allowedTypes = Map.of(
            Float.class, 0f,
            Integer.class, 0,
            Float2.class, Float2.ZERO,
            Int2.class, Int2.ZERO,
            Float3.class, Float3.ZERO,
            Int3.class, Int3.ZERO,
            Float4.class, Float4.ZERO,
            Int4.class, Int4.ZERO
    );

    // Methods

    /**
     * Constructs a new shader parameter map, given a list of names and their respective types.
     *
     * @param entries a list of pairs in the order specified by the shader. The {@code String} is the name, while the
     * {@code Class} represents the types of each parameter.
     */
    @SuppressWarnings("unchecked")
    public ShaderParamMap(List<Pair<String, Class<?>>> entries) {
        //temp variables for assigning
        Map<String, Integer> indexingMap_temp = new HashMap<>();
        List<Class<?>> clazzList_temp = Arrays.asList(new Class[entries.size()]);
        varList = Arrays.asList(new Object[entries.size()]);

        Pair<String, Class<?>> entry;
        Object defaultValue;
        for (int i = 0; i < entries.size(); i++) {
            entry = entries.get(i);
            defaultValue = allowedTypes.get(entry.getValue());
            if (defaultValue == null) {
                throw new IllegalArgumentException("parameter " + entry.getKey() + " is not a float, int, or vector thereof");
            }
            indexingMap_temp.put(entry.getKey(), i);
            clazzList_temp.set(i, entry.getValue());
            varList.set(i, defaultValue);
        }

        indexingMap = Map.copyOf(indexingMap_temp);
        clazzList = List.copyOf(clazzList_temp);
    }

    public void set(String name, Object o) {
        int index = indexingMap.get(name);

        Class<?> clazz = clazzList.get(index);
        if (!clazz.isInstance(o))
            throw new ClassCastException(o.toString() + " is not an instance of " + clazz.getName());

        varList.set(index, o);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        int index = indexingMap.getOrDefault(name, -1);

        if (index == -1)
            throw new NoSuchElementException(name + " is not a parameter of this map");

        return (T) varList.get(index);
    }

    public List<Class<?>> getClazzList() {
        return clazzList;
    }

    public List<Object> getVarList() {
        return Collections.unmodifiableList(varList);
    }

    // Vector classes (these should be replaced with records when possible)

    public static class Float2 {
        public static final Float2 ZERO = new Float2(0, 0);

        public final float x, y;

        public Float2(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Float2 float2 = (Float2) o;
            return Float.compare(float2.x, x) == 0 && Float.compare(float2.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("Float2(%s, %s)", x, y);
        }
    }

    public static class Float3 {
        public static final Float3 ZERO = new Float3(0, 0, 0);

        public final float x, y, z;

        public Float3(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Float3 float3 = (Float3) o;
            return Float.compare(float3.x, x) == 0 && Float.compare(float3.y, y) == 0 && Float.compare(float3.z, z) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }

        @Override
        public String toString() {
            return String.format("Float3(%s, %s, %s)", x, y, z);
        }
    }

    public static class Float4 {
        public static final Float4 ZERO = new Float4(0, 0, 0, 0);

        public final float x, y, z, w;

        public Float4(float x, float y, float z, float w) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Float4 float4 = (Float4) o;
            return Float.compare(float4.x, x) == 0 && Float.compare(float4.y, y) == 0 && Float.compare(float4.z, z) == 0 && Float.compare(float4.w, w) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z, w);
        }

        @Override
        public String toString() {
            return String.format("Float4(%s, %s, %s, %s)", x, y, z, w);
        }
    }

    public static class Int2 {
        public static final Int2 ZERO = new Int2(0, 0);

        public final int x, y;

        public Int2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Int2 int2 = (Int2) o;
            return x == int2.x && y == int2.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("Int2(%s, %s)", x, y);
        }
    }

    public static class Int3 {
        public static final Int3 ZERO = new Int3(0, 0, 0);

        public final int x, y, z;

        public Int3(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Int3 int3 = (Int3) o;
            return x == int3.x && y == int3.y && z == int3.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }

        @Override
        public String toString() {
            return String.format("Int3(%s, %s, %s)", x, y, z);
        }
    }

    public static class Int4 {
        public static final Int4 ZERO = new Int4(0, 0, 0, 0);

        public final int x, y, z, w;

        public Int4(int x, int y, int z, int w) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Int4 int4 = (Int4) o;
            return x == int4.x && y == int4.y && z == int4.z && w == int4.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z, w);
        }

        @Override
        public String toString() {
            return String.format("Int4(%s, %s, %s, %s)", x, y, z, w);
        }
    }
}
