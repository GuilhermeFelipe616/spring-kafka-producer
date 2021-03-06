package br.com.gfelipe.kafkaproducer.api.kafka

import br.com.gfelipe.kafkaproducer.api.kafka.request.ProducerRequest
import br.com.gfelipe.kafkaproducer.service.ProducerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka-example")
class KafkaProducerController(
    private val producerService: ProducerService
) {

    @PostMapping("/producers")
    fun producer(@RequestBody producerRequest: ProducerRequest) {
        producerService.produceMessage(producerRequest.message)
    }

}
