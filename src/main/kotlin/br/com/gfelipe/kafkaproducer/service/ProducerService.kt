package br.com.gfelipe.kafkaproducer.service

import br.com.gfelipe.kafkaproducer.dto.ProducerExampleDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProducerService(
    @Value(value = "\${example.kafka.topic}")
    private val producerTopic: String,
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    fun produceMessage(message: String) {
        val data = ProducerExampleDTO(message = message)
        kafkaTemplate.send(producerTopic, data)
    }

}
