package javafx.scene.paint;

import com.sun.javafx.sg.prism.NGPhongMaterial;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Represents a material backed by a user-defined shader.
 * @author Jacky Guo
 */
public class ShadedMaterial extends Material {
  private ObjectProperty<Shader> shader = new SimpleObjectProperty<>();

  public ShadedMaterial(Shader shader) {
    this.shader.setValue(shader);
    shader.link(this);
  }

  @Override
  void updatePG() {

  }

  @Override
  NGPhongMaterial getNGMaterial() {
    return null;
  }
}
