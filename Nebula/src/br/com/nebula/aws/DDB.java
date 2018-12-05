package br.com.nebula.aws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

import br.com.nebula.mp3.Tag;
import br.com.nebula.testes.TagTest;

public class DDB {

	public static void tableInfo() {
		final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();

		try {
			TableDescription table_info = ddb.describeTable("NebulaFiles").getTable();

			if (table_info != null) {
				System.out.format("Table name  : %s\n", table_info.getTableName());
				System.out.format("Table ARN   : %s\n", table_info.getTableArn());
				System.out.format("Status      : %s\n", table_info.getTableStatus());
				System.out.format("Item count  : %d\n", table_info.getItemCount().longValue());
				System.out.format("Size (bytes): %d\n", table_info.getTableSizeBytes().longValue());

				ProvisionedThroughputDescription throughput_info = table_info.getProvisionedThroughput();
				System.out.println("Throughput");
				System.out.format("  Read Capacity : %d\n", throughput_info.getReadCapacityUnits().longValue());
				System.out.format("  Write Capacity: %d\n", throughput_info.getWriteCapacityUnits().longValue());

				List<AttributeDefinition> attributes = table_info.getAttributeDefinitions();
				System.out.println("Attributes");
				for (AttributeDefinition a : attributes) {
					System.out.format("  %s (%s)\n", a.getAttributeName(), a.getAttributeType());
				}
			}
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		}
	}

	public static Map<String, String> getItem(String name, String projection_expression) {
		HashMap<String, AttributeValue> key_to_get = new HashMap<String, AttributeValue>();
		HashMap<String, String> tags = new HashMap<String, String>();
		
		key_to_get.put("fileKey", new AttributeValue(name));

		GetItemRequest request = null;
		if (projection_expression != null) {
			request = new GetItemRequest().withKey(key_to_get).withTableName("NebulaFiles")
					.withProjectionExpression(projection_expression);
		} else {
			request = new GetItemRequest().withKey(key_to_get).withTableName("NebulaFiles");
		}

		final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();

		try {
			Map<String, AttributeValue> item = ddb.getItem(request).getItem();
			if (item != null) {
				Set<String> keys = item.keySet();
				for (String key : keys) {
					tags.put(key, item.get(key).toString().substring(4, item.get(key).toString().length() - 2));
				}
				return tags;
			} else {
				System.out.format("No item found with the key %s!\n", "usuarios...");
			}
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		}
		return null;
	}

	public static void putItem(Tag t) {
		final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		mapper.save(t);
	}

	public static void deleteItem(String fileKey) {
		final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();
		DynamoDB dynamoDB = new DynamoDB(ddb);

		Table table = dynamoDB.getTable("NebulaFiles");

		DeleteItemOutcome outcome = table.deleteItem("fileKey", fileKey);

		// outcome.getDeleteItemResult();
	}

}
