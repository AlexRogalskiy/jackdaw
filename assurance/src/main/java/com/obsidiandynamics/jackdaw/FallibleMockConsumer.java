package com.obsidiandynamics.jackdaw;

import java.util.*;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.*;

abstract class FallibleMockConsumer<K, V> extends MockConsumer<K, V> {
  protected ExceptionGenerator<Map<TopicPartition, OffsetAndMetadata>, Exception> commitExceptionGenerator = ExceptionGenerator.never();
  
  protected final Object queuedMessagesMonitor = new Object();
  
  protected boolean queuedMessages;
  
  protected FallibleMockConsumer(OffsetResetStrategy offsetResetStrategy) {
    super(offsetResetStrategy);
  }
}
