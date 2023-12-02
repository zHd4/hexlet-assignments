package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> childs;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> childs) {
        super(name, attributes);

        this.body = body;
        this.childs = childs;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Map.Entry<String, String>> attributes = new ArrayList<>(getAttributes().entrySet());

        result.append('<').append(getName());

        if(!attributes.isEmpty()) {
            result.append(' ');

            for (int i = 0; i < attributes.size(); i++) {
                Map.Entry<String, String> attributeEntry = attributes.get(i);

                result.append(attributeEntry.getKey()).append("=\"").append(attributeEntry.getValue()).append('\"');
                if (i < attributes.size() - 1) result.append(' ');
            }
        }

        result.append('>').append(body);

        childs.forEach(child -> result.append(child.toString()));
        result.append("</").append(getName()).append('>');

        return result.toString();
    }
}
// END
