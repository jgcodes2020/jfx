package com.sun.prism;

public interface ShadedMaterial extends Material {

    void setFloat (String name, float x);
    void setFloat2(String name, float x, float y);
    void setFloat3(String name, float x, float y, float z);
    void setFloat4(String name, float x, float y, float z, float w);

    void setInt (String name, int x);
    void setInt2(String name, int x, int y);
    void setInt3(String name, int x, int y, int z);
    void setInt4(String name, int x, int y, int z, int w);

    void setTexture(ShadedTextureMap textureMap);
}
