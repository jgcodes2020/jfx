package javafx.scene.paint;

import javafx.scene.image.Image;

import java.net.URL;

/**
 * Represents a compiled shader. It contains methods to pass data to the underlying shader program.
 * @author Jacky Guo
 */
public class Shader {
  public static Shader compile(URL url) {
    return null;
  }

  public void pass(String name, float value) {

  }

  public void pass(String name, int value) {

  }

  public void pass(String name, boolean value) {

  }

  public void attachTexture(String name, Image value) {

  }

  public URL getShader() {
    return null;
  }

  void link(ShadedMaterial material) {

  }
}
