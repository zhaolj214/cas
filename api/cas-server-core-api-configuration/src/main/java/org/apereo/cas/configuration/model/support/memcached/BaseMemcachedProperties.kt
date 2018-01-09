package org.apereo.cas.configuration.model.support.memcached

import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [BaseMemcachedProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
open class BaseMemcachedProperties : Serializable {

    /**
     * Set to false if the default operation optimization is not desirable.
     */
    var isShouldOptimize: Boolean = false

    /**
     * Set the daemon state of the IO thread (defaults to true).
     */
    var isDaemon = true

    /**
     * Set the maximum reconnect delay.
     */
    var maxReconnectDelay: Long = -1

    /**
     * Set to true if you'd like to enable the Nagle algorithm.
     */
    var isUseNagleAlgorithm: Boolean = false

    /**
     * The number of seconds to wait for connections to finish before shutting
     * down the client.
     */
    var shutdownTimeoutSeconds: Long = -1

    /**
     * Set the maximum timeout exception threshold.
     */
    var timeoutExceptionThreshold = 2

    /**
     * Set the default operation timeout in milliseconds.
     */
    var opTimeout: Long = -1

    /**
     * Indicate the transcoder type. Accepted values are `KRYO, SERIAL, WHALIN, WHALINV1`.
     * The default is {code KRYO}.
     */
    var transcoder = "KRYO"

    /**
     * For transcoders other than kryo, determines the compression threshold.
     * Does not apply to kryo.
     */
    var transcoderCompressionThreshold = 16384

    /**
     * Comma-separated list of memcached servers.
     */
    @RequiredProperty
    var servers = "localhost:11211"

    /**
     * Failure mode. Acceptable values are `Redistribute,Retry,Cancel`.
     */
    var failureMode = "Redistribute"

    /**
     * Locator mode. Acceptable values are `ARRAY_MOD, CONSISTENT, VBUCKET`.
     */
    var locatorType = "ARRAY_MOD"

    /**
     * Hash algorithm. Acceptable values are `NATIVE_HASH,CRC_HASH,FNV1_64_HASH,FNV1A_64_HASH,FNV1_32_HASH,FNV1A_32_HASH,KETAMA_HASH`.
     */
    var hashAlgorithm = "FNV1_64_HASH"

    /**
     * Sets the cap on the number of objects that can be allocated by
     * the pool (checked out to clients, or idle awaiting checkout) at a given time. Use a negative value for no limit.
     */
    var maxTotal = 20

    /**
     * Set the value for the maxTotal configuration attribute for pools created with this configuration instance.
     */
    var maxIdle = 8

    /**
     * Get the value for the minIdle configuration attribute for pools created with this configuration instance.
     */
    var minIdle: Int = 0

    /**
     * If true, `reset` is called automatically after an entire object graph has been read or written. If
     * false, `reset` must be called manually, which allows unregistered class names, references, and other information to
     * span multiple object graphs.
     */
    var isKryoAutoReset: Boolean = false

    /**
     * If true, each appearance of an object in the graph after the first is stored as an integer ordinal. When set to true,
     * `MapReferenceResolver` is used. This enables references to the same object and cyclic graphs to be serialized, but
     * typically adds overhead of one byte per object.
     */
    var isKryoObjectsByReference: Boolean = false

    /**
     * If true, an exception is thrown when an unregistered class is encountered.
     *
     *
     * If false, when an unregistered class is encountered, its fully qualified class name will be serialized and the
     * default serializer for the class used to serialize the object. Subsequent
     * appearances of the class within the same object graph are serialized as an int id.
     * Registered classes are serialized as an int id, avoiding the overhead of serializing the class name, but have the drawback
     * of needing to know the classes to be serialized up front.  See `ComponentSerializationPlan` for help here.
     *
     */
    var isKryoRegistrationRequired = true

    companion object {

        private const val serialVersionUID = 514520518053691666L
    }
}



