package com.sun.prism;

/**
 * Named texture map for custom shaders.
 */
public class ShadedTextureMap implements TextureMap {
  private String name;
  private Image image;
  private Texture texture;
  private boolean dirty;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public void setImage(Image image) {
    this.image = image;
  }

  @Override
  public Texture getTexture() {
    return texture;
  }

  @Override
  public void setTexture(Texture texture) {
    this.texture = texture;
  }

  @Override
  public boolean isDirty() {
    return dirty;
  }

  @Override
  public void setDirty(boolean dirty) {
    this.dirty = dirty;
  }
}
