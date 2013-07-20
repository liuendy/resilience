package io.latent.resilience

import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy

/**
 * Hystrix Config
 *
 * It is preferrable to configure the optional values via properties as documented on the following link.
 * @see https://github.com/Netflix/Hystrix/wiki/Configuration
 *
 * @author peter@latent.io
 */
case class HystrixConfig(group: String,
                         command: String,
                         timeout: Option[Int] = None,
                         isolation: Option[ExecutionIsolationStrategy] = None,
                         isolationSemaphoreMax: Option[Int] = None,
                         threadPoolSize: Option[Int] = None)
