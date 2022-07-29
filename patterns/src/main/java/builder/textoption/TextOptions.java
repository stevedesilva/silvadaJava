package builder.textoption;

import java.awt.*;
import java.util.Optional;
import java.util.OptionalDouble;

public final class TextOptions {
    private final String font;
    private final OptionalDouble fontSize;
    private final Optional<Color> color;

    private TextOptions(Builder builder) {
        this.font = builder.font;
        this.fontSize = builder.fontSize;
        this.color = builder.color;
    }

    public static void main(String[] args) {
          TextOptions textOptions = new Builder(Font.SERIF).setColor(Color.BLACK).build();
    }

    public String getFont() {
        return font;
    }

    public OptionalDouble getFontSize() {
        return fontSize;
    }

    public Optional<Color> getColor() {
        return color;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private String font;
        private OptionalDouble fontSize = OptionalDouble.empty();
        private Optional<Color> color = Optional.empty();

        public Builder(String font) {
            this.font = font;
        }

        private Builder(TextOptions textOptions) {
            this.font = textOptions.font;
            this.fontSize = textOptions.fontSize;
            this.color = textOptions.color;
        }

        public Builder setFont(String font) {
            this.font = font;
            return this;
        }

        public Builder setFontSize(double fontSize) {
            this.fontSize = OptionalDouble.of(fontSize);
            return this;
        }

        public Builder setColor(Color color) {
            this.color = Optional.of(color);
            return this;
        }

        public Builder clearBuilder() {
            this.font = null;
            this.fontSize = OptionalDouble.empty();
            this.color = Optional.empty();
            return this;
        }

        public TextOptions build(){
            return new TextOptions(this);
        }

    }
}
