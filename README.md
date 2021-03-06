resilience
==========

[![Build Status](https://travis-ci.org/ppat/resilience.png)](https://travis-ci.org/ppat/resilience)

    “Do the things that interest you and do them with all your heart. Don't be concerned about whether people are 
    watching you or criticizing you. The chances are that they aren't paying any attention to you. It's your 
    attention to yourself that is so stultifying. But you have to disregard yourself as completely as possible. 
    If you fail the first time then you'll just have to try harder the second time. After all, there's no real 
    reason why you should fail. Just stop thinking about yourself.” 
                                                         ― Eleanor Roosevelt

A scala DSL for Netflix Hystrix for building resilient applications

## Use

Build and add this to the your maven POM (or built.sbt for SBT)
```xml
        <dependency>
            <groupId>io.latent</groupId>
            <artifactId>resilience</artifactId>
            <version>LATEST-VERSION</version>
        </dependency>
```

### Gracefully degrade

* yes, that means throwing exception when underlying command
  * fails
  * times out
  * circuit breaker trips
  * thread pool is exhausted or semaphore max reached

```scala
import io.latent.resilience.HystrixConfig
import io.latent.resilience.HystrixDSL._

implicit val config = HystrixConfig("APP-NAME", "search-title-nationwide", Some(1 second))
gracefully {
   search(title, page, pageSize, matchAllFilter(), sort)
} degrade()
```

### Gracefully fallback

* you must have a fallback that actually makes SENSE in your use case for this option

```scala
import io.latent.resilience.HystrixConfig
import io.latent.resilience.HystrixDSL._

implicit val config = HystrixConfig("APP-NAME", "search-title-nationwide", Some(1 second))
gracefully {
  search(title, page, pageSize, matchAllFilter(), sort)
} fallback {
  List.empty
}
```
