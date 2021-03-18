package javafx.scene.paint;

import com.sun.javafx.sg.prism.NGPhongMaterial;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Represents a material coloured by a user-defined shader.
 * @author Jacky Guo
 */
public class ShadedMaterial extends Material {
  private final ObjectProperty<Shader> shader = new SimpleObjectProperty<>();

  /**
   * Creates a new {@code ShadedMaterial} using the given {@link Shader}.
   * @param shader the shader to use with this material
   */
  public ShadedMaterial(Shader shader) {
    this.shader.setValue(shader);
    shader.link(this);
  }

  /**
   * Returns the value of the {@code shader} property.
   * @return the value of the shader property
   */
  public Shader getShader() {
    return shader.get();
  }

  /**
   * The shader that was used to construct this {@code ShadedMaterial}.
   * @return a read-only property referencing the shader
   */
  public ReadOnlyObjectProperty<Shader> shaderProperty() {
    return shader;
  }

  @Override
  void updatePG() {

  }

  @Override
  NGPhongMaterial getNGMaterial() {
    return null;
  }
}
