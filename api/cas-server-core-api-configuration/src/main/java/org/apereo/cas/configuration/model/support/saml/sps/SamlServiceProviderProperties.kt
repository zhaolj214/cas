package org.apereo.cas.configuration.model.support.saml.sps

import org.apereo.cas.configuration.support.RequiresModule
import java.io.Serializable

/**
 * This is [SamlServiceProviderProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-saml-sp-integrations")
class SamlServiceProviderProperties : Serializable {

    /**
     * Settings related to Hipchat acting as a SAML service provider.
     */
    var hipchat = Hipchat()
    /**
     * Settings related to Gitlab acting as a SAML service provider.
     */
    var gitlab = Gitlab()
    /**
     * Settings related to Dropbox acting as a SAML service provider.
     */
    var dropbox = Dropbox()
    /**
     * Settings related to Workday acting as a SAML service provider.
     */
    var workday = Workday()
    /**
     * Settings related to SA Manage acting as a SAML service provider.
     */
    var saManage = SAManage()
    /**
     * Settings related to Salesforce acting as a SAML service provider.
     */
    var salesforce = Salesforce()
    /**
     * Settings related to ServiceNow acting as a SAML service provider.
     */
    var serviceNow = ServiceNow()
    /**
     * Settings related to Box acting as a SAML service provider.
     */
    var box = Box()
    /**
     * Settings related to NetPartner acting as a SAML service provider.
     */
    var netPartner = NetPartner()
    /**
     * Settings related to Webex acting as a SAML service provider.
     */
    var webex = Webex()
    /**
     * Settings related to Office365 acting as a SAML service provider.
     */
    var office365 = Office365()
    /**
     * Settings related to TestShib acting as a SAML service provider.
     */
    var testShib = TestShib()
    /**
     * Settings related to InCommon acting as a SAML service provider.
     */
    var inCommon = InCommon()
    /**
     * Settings related to ZOOM acting as a SAML service provider.
     */
    var zoom = Zoom()
    /**
     * Settings related to Evernote acting as a SAML service provider.
     */
    var evernote = Evernote()
    /**
     * Settings related to Asana acting as a SAML service provider.
     */
    var asana = Asana()
    /**
     * Settings related to Gartner acting as a SAML service provider.
     */
    var gartner = Gartner()
    /**
     * Settings related to Tableu acting as a SAML service provider.
     */
    var tableau = Tableau()
    /**
     * Settings related to WebAdvisor acting as a SAML service provider.
     */
    var webAdvisor = WebAdvisor()
    /**
     * Settings related to OpenAthens acting as a SAML service provider.
     */
    var openAthens = OpenAthens()
    /**
     * Settings related to ArcGIS acting as a SAML service provider.
     */
    var arcGIS = ArcGIS()
    /**
     * Settings related to BenefitFocus acting as a SAML service provider.
     */
    var benefitFocus = BenefitFocus()
    /**
     * Settings related to Adobe Cloud acting as a SAML service provider.
     */
    var adobeCloud = AdobeCloud()
    /**
     * Settings related to Academic Works acting as a SAML service provider.
     */
    var academicWorks = AcademicWorks()
    /**
     * Settings related to Easy IEP acting as a SAML service provider.
     */
    var easyIep = EasyIep()
    /**
     * Settings related to InfiniteCampus acting as a SAML service provider.
     */
    var infiniteCampus = InfiniteCampus()
    /**
     * Settings related to SecuringTheHuman acting as a SAML service provider.
     */
    var sansSth = SecuringTheHuman()
    /**
     * Settings related to Slack acting as a SAML service provider.
     */
    var slack = Slack()
    /**
     * Settings related to Zendesk acting as a SAML service provider.
     */
    var zendesk = Zendesk()
    /**
     * Settings related to Bynder acting as a SAML service provider.
     */
    var bynder = Bynder()
    /**
     * Settings related to Famis acting as a SAML service provider.
     */
    var famis = Famis()
    /**
     * Settings related to Sunshine state ed/release alliance acting as a SAML service provider.
     */
    var sserca = SunshineStateEdResearchAlliance()
    /**
     * Settings related to EverBridge acting as a SAML service provider.
     */
    var everBridge = EverBridge()
    /**
     * Settings related to CherWell acting as a SAML service provider.
     */
    var cherWell = CherWell()
    /**
     * Settings related to CherWell acting as a SAML service provider.
     */
    var egnyte = Egnyte()
    /**
     * Settings related to CherWell acting as a SAML service provider.
     */
    var newRelic = NewRelic()
    /**
     * Settings related to Yuja acting as a SAML service provider.
     */
    var yuja = Yuja()
    /**
     * Settings related to Symplicity acting as a SAML service provider.
     */
    var symplicity = Symplicity()
    /**
     * Settings related to AppDynamics acting as a SAML service provider.
     */
    var appDynamics = AppDynamics()
    /**
     * Settings related to Amazon acting as a SAML service provider.
     */
    var amazon = Amazon()

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Dropbox : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "mail"
        }

        companion object {
            private val serialVersionUID = -8275173711355379058L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Box : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("firstName", "lastName")
        }

        companion object {
            private val serialVersionUID = -5320292115253509284L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class SAManage : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "mail"
        }

        companion object {
            private val serialVersionUID = -8695176237527302883L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Workday : AbstractSamlSPProperties() {
        init {
            isSignAssertions = true
            isSignResponses = true
        }

        companion object {
            private val serialVersionUID = 3484810792914261584L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Famis : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = 4685484530782109454L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Salesforce : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("mail", EDU_PERSON_PRINCIPAL_NAME)
        }

        companion object {
            private val serialVersionUID = 4685484530782109454L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class ServiceNow : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf(EDU_PERSON_PRINCIPAL_NAME)
        }

        companion object {
            private val serialVersionUID = 4329681021653966734L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class NetPartner : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "studentId"
        }

        companion object {
            private val serialVersionUID = 5262806306575955633L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Office365 : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "scopedImmutableID"
            attributes = mutableListOf("IDPEmail", "ImmutableID")
            isSignResponses = false
            isSignAssertions = true
        }

        companion object {
            private val serialVersionUID = 5878458463269060163L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class WebAdvisor : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("uid")
        }

        companion object {
            private val serialVersionUID = 8449304623099588610L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Webex : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = EMAIL
            attributes = mutableListOf("firstName", "lastName")
            isSignResponses = false
            isSignAssertions = true
        }

        companion object {
            private val serialVersionUID = 1957066095836617091L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Tableau : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("username")
        }

        companion object {
            private val serialVersionUID = -2426590644028989950L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class TestShib : AbstractSamlSPProperties() {
        init {
            //setMetadata("http://www.testshib.org/metadata/testshib-providers.xml");
            attributes = mutableListOf(EDU_PERSON_PRINCIPAL_NAME)
        }

        companion object {
            private val serialVersionUID = -622256214333755377L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Zoom : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "mail"
            attributes = mutableListOf("mail", "sn", "givenName")
        }

        companion object {
            private val serialVersionUID = -4877129302021248398L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class ArcGIS : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "arcNameId"
            attributes = mutableListOf("mail", "givenName", "arcNameId")
        }

        companion object {
            private val serialVersionUID = 2976006720801066953L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class InCommon : AbstractSamlSPProperties() {
        init {
            //setMetadata("http://md.incommon.org/InCommon/InCommon-metadata.xml");
            //setSignatureLocation("/etc/cas/config/certs/inc-md-cert.pem");
            attributes = mutableListOf(EDU_PERSON_PRINCIPAL_NAME)
        }

        companion object {
            private val serialVersionUID = -6336757169059216490L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Evernote : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = EMAIL
            nameIdFormat = "emailAddress"
        }

        companion object {
            private val serialVersionUID = -1333379518527897627L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Asana : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = EMAIL
            nameIdFormat = "emailAddress"
        }

        companion object {
            private val serialVersionUID = 6392492484052314295L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class OpenAthens : AbstractSamlSPProperties() {
        init {
            //setMetadata("https://login.openathens.net/saml/2/metadata-sp");
            attributes = mutableListOf(EDU_PERSON_PRINCIPAL_NAME, EMAIL)
        }

        companion object {
            private val serialVersionUID = 7295249577313928465L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class BenefitFocus : AbstractSamlSPProperties() {
        init {
            nameIdAttribute = "benefitFocusUniqueId"
        }

        companion object {
            private val serialVersionUID = -6518570556068267724L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class AdobeCloud : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("firstName", "lastName")
        }

        companion object {
            private val serialVersionUID = -5466434234795577247L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class AcademicWorks : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("displayName", EMAIL)
        }

        companion object {
            private val serialVersionUID = 5855725238963607605L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class EasyIep : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("employeeId")
        }

        companion object {
            private val serialVersionUID = 6177866628049579956L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class InfiniteCampus : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("employeeId")
        }

        companion object {
            private val serialVersionUID = -9023417844664430533L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class SecuringTheHuman : AbstractSamlSPProperties() {
        init {
            attributes = mutableListOf("firstName", "lastName", EMAIL, "scopedUserId", "department", "reference")
        }

        companion object {
            private val serialVersionUID = -1688194227471468248L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Slack : AbstractSamlSPProperties() {
        init {
            nameIdFormat = "persistent"
            attributes = mutableListOf("User.Email", "User.Username", "first_name", "last_name")
            nameIdAttribute = "employeeId"
        }

        companion object {
            private val serialVersionUID = -1996859011579246804L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Zendesk : AbstractSamlSPProperties() {
        init {
            nameIdFormat = "emailAddress"
            nameIdAttribute = "email"
            attributes = mutableListOf("organization", "tags", "phone", "role")
        }

        companion object {
            private val serialVersionUID = -4668960591734555087L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Bynder : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -3168960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class CherWell : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -3168960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class NewRelic : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -3268960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Yuja : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -1168960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Symplicity : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -3178960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Egnyte : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -3168760591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class EverBridge : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -5168960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class SunshineStateEdResearchAlliance : AbstractSamlSPProperties() {
        companion object {
            private val serialVersionUID = -5558960591734555088L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Gartner : AbstractSamlSPProperties() {
        init {
            setAttributes("urn:oid:2.5.4.42", "urn:oid:2.5.4.4", "urn:oid:0.9.2342.19200300.100.1.3")
        }

        companion object {
            private val serialVersionUID = -6141931806328699054L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Gitlab : AbstractSamlSPProperties() {
        init {
            setAttributes(EMAIL, "last_name", "first_name", "name")
        }

        companion object {
            private val serialVersionUID = -6141931806328699054L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Hipchat : AbstractSamlSPProperties() {
        init {
            setAttributes(EMAIL, "last_name", "first_name", "title")
        }

        companion object {
            private val serialVersionUID = -6141931806328699054L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class AppDynamics : AbstractSamlSPProperties() {
        init {
            setAttributes("User.OpenIDName", "User.email", "User.fullName", "AccessControl", "Groups-Membership")
        }

        companion object {
            private val serialVersionUID = -6141931806328699054L
        }
    }

    @RequiresModule(name = "cas-server-support-saml-sp-integrations")
    class Amazon : AbstractSamlSPProperties() {
        init {
            isSignAssertions = true
            isSignResponses = false
            setAttributes("awsRoles", "awsRoleSessionName")
        }

        companion object {
            private val serialVersionUID = -6141931806328699054L
        }
    }

    companion object {
        /**
         * `email` attribute to release.
         */
        private val EMAIL = "email"
        /**
         * `eduPersonPrincipalName` attribute to release.
         */
        private val EDU_PERSON_PRINCIPAL_NAME = "eduPersonPrincipalName"
        private const val serialVersionUID = 8602328179113963081L
    }


}
