package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
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

        result.append('>');
        return result.toString();
    }
}
// END
