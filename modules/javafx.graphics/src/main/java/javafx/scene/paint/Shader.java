package javafx.scene.paint;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.net.URL;
import java.util.Objects;

/**
 * Represents a compiled shader. It contains methods to pass data to the underlying shader program.
 * @author Jacky Guo
 */
public final class Shader {

  /**
   * Compiles the JSL shader at the given URL, returning a {@code Shader} object.
   * @param url the URL of the JSL shader
   * @return a new {@code Shader} which is compiled from {@code url}
   */
  public static Shader compile(URL url) {
    // TODO call JSL compiler and generate native peer
    return null;
  }

  /**
   * Passes a {@code float} value to the shader.
   * @param name a variable name
   * @param value the value to pass to that variable
   */
  public void pass(String name, float value) {

  }

  /**
   * Passes an {@code int} value to the shader.
   * @param name a variable name
   * @param value the value to pass to that variable
   */
  public void pass(String name, int value) {

  }

  /**
   * Attaches a texture to the shader. Changes made to the texture will be reflected during rendering.
   * @param name a variable name representing a sampler
   * @param value the texture to attach to this name.
   */
  public void attachTexture(String name, WritableImage value) {

  }

  /**
   * Internal - called during the construction of {@link ShadedMaterial} to perform shader-side init.
   * @param material the {@code ShadedMaterial} linking to this shader
   */
  void link(ShadedMaterial material) {

  }
}
