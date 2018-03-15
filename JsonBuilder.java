public class JsonBuilder {

	private String str;
	private boolean first;
	
	public JsonBuilder() {
		str = "";
		first = true;
	}
	
	public JsonBuilder addElement(String name, String value) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += "\"" + name + "\":\"" + value + "\"";
		return this;
	}
	
	public JsonBuilder addElement(String name, int value) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += "\"" + name + "\":" + value;
		return this;
	}
	
	public JsonBuilder addElement(String name, double value) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += "\"" + name + "\":" + value;
		return this;
	}
	
	public JsonBuilder addElement(String value) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += "\"" + value + "\"";
		return this;
	}

	public JsonBuilder addElement(int value) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += value;
		return this;
	}
	
	public JsonBuilder addElement(double value) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += value;
		return this;
	}
	
	public JsonBuilder addItem(JsonBuilder jb) {
		if (!first)
			str += ", ";
		else
			first = false;
		str += jb.toString();
		return this;
	}
	
	public JsonBuilder startArray(String name) {
		if (!first) {
			str += ", ";
			first = true;
		}
		str += "\"" + name + "\":[";
		return this;
	}
	
	public JsonBuilder closeArray() {
		str += "]";
		return this;
	}
	
	public String toString() {
		return "{" + str + "}";
	}
	
	public static void main(String[] args) {
		String json = new JsonBuilder()
							.addElement("name", "John")
							.addElement("age", 30)
							.startArray("cars")
								.addItem(new JsonBuilder()
									.addElement("name",  "Ford")
									.startArray("models")
										.addElement("Fiesta")
										.addElement("Focus")
										.addElement("Mustang")
									.closeArray())
								.addItem(new JsonBuilder()
									.addElement("name", "BMW")
									.startArray("models")
										.addElement("320")
										.addElement("X3")
										.addElement("X5")
									.closeArray())
								.addItem(new JsonBuilder()
									.addElement("name", "FIAT")
									.startArray("models")
										.addElement("500")
										.addElement("Panda")
									.closeArray())
							.closeArray()
							.toString();
		System.out.println(json);
	}
	
}
