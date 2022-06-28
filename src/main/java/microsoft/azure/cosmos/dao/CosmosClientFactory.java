package microsoft.azure.cosmos.dao;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;

public class CosmosClientFactory {
    private static final String HOST = "https://rayscarwash.documents.azure.com:443/";
    private static final String MASTER_KEY = "ZccxOSAVCAbplUU8ySdiYrRWWKWsfCBdSdrkWtQbQjPwJ8Fzv6HZrUvt02blIfVreOIZQTnKUoun3FmK6cY1EQ==";

    private static CosmosClient cosmosClient = new CosmosClientBuilder()
            .endpoint(HOST)
            .key(MASTER_KEY)
            .consistencyLevel(ConsistencyLevel.EVENTUAL)
            .buildClient();

    public static CosmosClient getCosmosClient() {
        return cosmosClient;
    }

}