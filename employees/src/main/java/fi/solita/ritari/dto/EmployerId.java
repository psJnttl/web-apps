package fi.solita.ritari.dto;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = EmployerIdDeserializer.class)
public class EmployerId {
	private long id;
    
    public EmployerId(BigInteger bigInt) {
    	id = bigInt.longValue();
    }
    public long getEmployerId() {
    	return id;
    }
    public EmployerId() {} // needed for deserialization
    public EmployerId(long id) {this.id = id;} // needed for custom deserialization
}

class EmployerIdDeserializer extends JsonDeserializer<EmployerId> {

	@Override
	public EmployerId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)	throws IOException, JsonProcessingException {
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		long id = node.get("employerId").longValue();
		return new EmployerId(id);
	}
	
}