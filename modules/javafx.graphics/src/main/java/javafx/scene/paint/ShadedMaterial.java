package javafx.scene.paint;

import com.sun.javafx.sg.prism.NGPhongMaterial;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Represents a material coloured by a user-defined fragment shader.
 * @author Jacky Guo
 */
public class ShadedMaterial extends Material {
  private final ObjectProperty<Shader> fragmentShader = new SimpleObjectProperty<>();

  /**
   * Creates a new {@code ShadedMaterial} using the given {@link Shader}.
   * @param shader the shader to use with this material. Use {@code null} to use the internal default shader.
   */
  public ShadedMaterial(Shader shader) {
    super();

    this.fragmentShader.set(shader);
    if (shader != null)
      shader.link(this);
  }

  public Shader getFragmentShader() {
    return fragmentShader.get();
  }

  @Override
  void updatePG() {

  }

  @Override
  NGPhongMaterial getNGMaterial() {
    return null;
  }

  @Override
  public String toString() {
    return "ShadedMaterial[" +
            "fragmentShader=" + fragmentShader +
            ']';
  }
}
