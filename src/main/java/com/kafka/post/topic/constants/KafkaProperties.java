package com.kafka.post.topic.constants;

public class KafkaProperties {

    public final static String BOOTSTRAP_SERVERS_KEY= "bootstrap.servers";

    public final static String BOOTSTRAP_ACKS_KEY= "acks";

    public final static String BOOTSTRAP_ACKS_VALUE= "all";

    public final static String BOOTSTRAP_RETRIES_KEY= "retries";

    public final static String BOOTSTRAP_BATCH_SIZE_KEY= "batch.size";

    public final static String BOOTSTRAP_LINGER_MS_KEY= "linger.ms";

    public final static String BOOTSTRAP_BUFFER_MEMEORY_KEY= "buffer.memory";

    public final static String BOOTSTRAP_SERIALIZER_KEY= "key.serializer";

    public final static String BOOTSTRAP_SERIALIZER_VALUE= "org.apache.kafka.common.serialization.StringSerializer";

    public final static String BOOTSTRAP_SERIALIZER_VALUE_KEY= "value.serializer";

    public final static String BOOTSTRAP_SERIALIZER_VALUE_VALUE= "org.apache.kafka.common.serialization.StringSerializer";

}
