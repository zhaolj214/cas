package org.apereo.cas.configuration

import org.apereo.cas.configuration.model.core.CasServerProperties
import org.apereo.cas.configuration.model.core.HostProperties
import org.apereo.cas.configuration.model.core.audit.AuditProperties
import org.apereo.cas.configuration.model.core.authentication.AuthenticationProperties
import org.apereo.cas.configuration.model.core.authentication.HttpClientProperties
import org.apereo.cas.configuration.model.core.authentication.PersonDirectoryPrincipalResolverProperties
import org.apereo.cas.configuration.model.core.events.EventsProperties
import org.apereo.cas.configuration.model.core.logout.LogoutProperties
import org.apereo.cas.configuration.model.core.metrics.MetricsProperties
import org.apereo.cas.configuration.model.core.monitor.MonitorProperties
import org.apereo.cas.configuration.model.core.rest.RestProperties
import org.apereo.cas.configuration.model.core.services.ServiceRegistryProperties
import org.apereo.cas.configuration.model.core.slo.SloProperties
import org.apereo.cas.configuration.model.core.sso.SsoProperties
import org.apereo.cas.configuration.model.core.util.TicketProperties
import org.apereo.cas.configuration.model.core.web.MessageBundleProperties
import org.apereo.cas.configuration.model.core.web.security.AdminPagesSecurityProperties
import org.apereo.cas.configuration.model.core.web.security.HttpRequestProperties
import org.apereo.cas.configuration.model.core.web.view.ViewProperties
import org.apereo.cas.configuration.model.support.analytics.GoogleAnalyticsProperties
import org.apereo.cas.configuration.model.support.aup.AcceptableUsagePolicyProperties
import org.apereo.cas.configuration.model.support.captcha.GoogleRecaptchaProperties
import org.apereo.cas.configuration.model.support.clearpass.ClearpassProperties
import org.apereo.cas.configuration.model.support.consent.ConsentProperties
import org.apereo.cas.configuration.model.support.cookie.TicketGrantingCookieProperties
import org.apereo.cas.configuration.model.support.cookie.WarningCookieProperties
import org.apereo.cas.configuration.model.support.geo.googlemaps.GoogleMapsProperties
import org.apereo.cas.configuration.model.support.geo.maxmind.MaxmindProperties
import org.apereo.cas.configuration.model.support.interrupt.InterruptProperties
import org.apereo.cas.configuration.model.support.jpa.DatabaseProperties
import org.apereo.cas.configuration.model.support.saml.SamlCoreProperties
import org.apereo.cas.configuration.model.support.saml.googleapps.GoogleAppsProperties
import org.apereo.cas.configuration.model.support.saml.mdui.SamlMetadataUIProperties
import org.apereo.cas.configuration.model.support.saml.shibboleth.ShibbolethAttributeResolverProperties
import org.apereo.cas.configuration.model.support.saml.sps.SamlServiceProviderProperties
import org.apereo.cas.configuration.model.support.scim.ScimProperties
import org.apereo.cas.configuration.model.support.sms.ClickatellProperties
import org.apereo.cas.configuration.model.support.sms.TextMagicProperties
import org.apereo.cas.configuration.model.support.sms.TwilioProperties
import org.apereo.cas.configuration.model.support.themes.ThemeProperties
import org.apereo.cas.configuration.model.webapp.LocaleProperties
import org.apereo.cas.configuration.model.webapp.WebflowProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [CasConfigurationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@ConfigurationProperties(value = "cas")
class CasConfigurationProperties : Serializable {

    /**
     * Interrupt/notification functionality.
     */
    @NestedConfigurationProperty
    var interrupt = InterruptProperties()

    /**
     * Attribute consent functionality.
     */
    @NestedConfigurationProperty
    var consent = ConsentProperties()

    /**
     * SCIM functionality.
     */
    @NestedConfigurationProperty
    var scim = ScimProperties()

    /**
     * General settings for authentication.
     */
    @NestedConfigurationProperty
    var authn = AuthenticationProperties()

    /**
     * Authentication audit functionality.
     */
    @NestedConfigurationProperty
    var audit = AuditProperties()

    /**
     * Http client and outgoing connections settings.
     */
    @NestedConfigurationProperty
    var httpClient = HttpClientProperties()

    /**
     * Person directory and principal resolution functionality.
     */
    @NestedConfigurationProperty
    var personDirectory = PersonDirectoryPrincipalResolverProperties()

    /**
     * Authentication events functionality.
     */
    @NestedConfigurationProperty
    var events = EventsProperties()

    /**
     * Settings that define this CAS host.
     */
    @NestedConfigurationProperty
    var host = HostProperties()

    /**
     * Logout functionality.
     */
    @NestedConfigurationProperty
    var logout = LogoutProperties()

    /**
     * Metrics functionality.
     */
    @NestedConfigurationProperty
    var metrics = MetricsProperties()

    /**
     * Monitoring functionality.
     */
    @NestedConfigurationProperty
    var monitor = MonitorProperties()

    /**
     * REST API functionality.
     */
    @NestedConfigurationProperty
    var rest = RestProperties()

    /**
     * Settings that define this CAS server instance.
     */
    @NestedConfigurationProperty
    var server = CasServerProperties()

    /**
     * Service registry functionality.
     */
    @NestedConfigurationProperty
    var serviceRegistry = ServiceRegistryProperties()

    /**
     * SLO functionality.
     */
    @NestedConfigurationProperty
    var slo = SloProperties()

    /**
     * SSO functionality.
     */
    @NestedConfigurationProperty
    var sso = SsoProperties()

    /**
     * Ticketing functionality.
     */
    @NestedConfigurationProperty
    var ticket = TicketProperties()

    /**
     * Message bundles and internationalization functionality.
     */
    @NestedConfigurationProperty
    var messageBundle = MessageBundleProperties()

    /**
     * Admin pages and their security, controling endpoints, etc.
     */
    @NestedConfigurationProperty
    var adminPagesSecurity = AdminPagesSecurityProperties()

    /**
     * Settings that control filtering of the incoming http requests.
     */
    @NestedConfigurationProperty
    var httpWebRequest = HttpRequestProperties()

    /**
     * Views and UI functionality.
     */
    @NestedConfigurationProperty
    var view = ViewProperties()

    /**
     * Google Analytics functionality.
     */
    @NestedConfigurationProperty
    var googleAnalytics = GoogleAnalyticsProperties()

    /**
     * Google reCAPTCHA settings.
     */
    @NestedConfigurationProperty
    var googleRecaptcha = GoogleRecaptchaProperties()

    /**
     * Twilio settings.
     */
    @NestedConfigurationProperty
    var twilio = TwilioProperties()

    /**
     * TextMagic settings.
     */
    @NestedConfigurationProperty
    var textMagic = TextMagicProperties()

    /**
     * Clickatell settings.
     */
    @NestedConfigurationProperty
    var clickatell = ClickatellProperties()

    /**
     * AUP settings.
     */
    @NestedConfigurationProperty
    var acceptableUsagePolicy = AcceptableUsagePolicyProperties()

    /**
     * Clearpass settings.
     */
    @NestedConfigurationProperty
    var clearpass = ClearpassProperties()

    /**
     * Ticket-granting cookie settings.
     */
    @NestedConfigurationProperty
    var tgc = TicketGrantingCookieProperties()

    /**
     * Warning cookie settings.
     */
    @NestedConfigurationProperty
    var warningCookie = WarningCookieProperties()

    /**
     * SAML SP integration settings.
     */
    @NestedConfigurationProperty
    var samlSp = SamlServiceProviderProperties()

    /**
     * MaxMind settings.
     */
    @NestedConfigurationProperty
    var maxmind = MaxmindProperties()

    /**
     * Google Maps settings.
     */
    @NestedConfigurationProperty
    var googleMaps = GoogleMapsProperties()

    /**
     * General database and hibernate settings.
     */
    @NestedConfigurationProperty
    var jdbc = DatabaseProperties()

    /**
     * Google Apps integration settings.
     */
    @NestedConfigurationProperty
    var googleApps = GoogleAppsProperties()

    /**
     * SAML Metadata UI settings and parsing.
     */
    @NestedConfigurationProperty
    var samlMetadataUi = SamlMetadataUIProperties()

    /**
     * SAML Core functionality and settings.
     */
    @NestedConfigurationProperty
    var samlCore = SamlCoreProperties()

    /**
     * Shibboleth attribute resolution settings.
     */
    @NestedConfigurationProperty
    var shibAttributeResolver = ShibbolethAttributeResolverProperties()

    /**
     * UI and theme settings.
     */
    @NestedConfigurationProperty
    var theme = ThemeProperties()

    /**
     * Locale and internationalization settings.
     */
    @NestedConfigurationProperty
    var locale = LocaleProperties()

    /**
     * Spring Webflow functionality.
     */
    @NestedConfigurationProperty
    var webflow = WebflowProperties()

    companion object {
        /**
         * Prefix used for all CAS-specific settings.
         */
        val PREFIX = "cas"

        private const val serialVersionUID = -8620267783496071683L
    }
}
