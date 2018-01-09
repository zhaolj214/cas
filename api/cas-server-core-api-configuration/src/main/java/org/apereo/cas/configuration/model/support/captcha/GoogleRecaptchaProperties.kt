package org.apereo.cas.configuration.model.support.captcha

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [GoogleRecaptchaProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-captcha")
class GoogleRecaptchaProperties : Serializable {

    /**
     * Whether google reCAPTCHA should be enabled.
     */
    var isEnabled = true
    /**
     * The google reCAPTCHA site key.
     */
    var siteKey: String? = null
    /**
     * The google reCAPTCHA endpoint for verification of tokens and input.
     */
    var verifyUrl = "https://www.google.com/recaptcha/api/siteverify"
    /**
     * The google reCAPTCHA site secret.
     */
    var secret: String? = null

    companion object {
        private const val serialVersionUID = -8955074129123813915L
    }
}
