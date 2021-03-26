package com.sun.prism;

public interface TextureMap {
  public Image getImage();

  public void setImage(Image image);

  public Texture getTexture();

  public void setTexture(Texture texture);

  public boolean isDirty();

  public void setDirty(boolean dirty);
}
