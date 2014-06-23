package mobi.nuuvo.frimgle.server.player.config.ctastripe;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithDefaultText;
import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrAndSource;

import javax.xml.bind.annotation.*;

/**
 * Created by svd on 6/18/14.
 * {@code
 * <!--
 * <p/>
 * https://stripe.com/docs/testing testing assets
 * amount (in cents) currency attribute values: EUR, USD see @ https://support.stripe.com/questions/which-currencies-does-stripe-support
 * -->
 * <CTAStripe amount="300" currency="usd">
 * <namefield x="18" y="18" width="360" height="30" font="Helvetica" size="20" color="#6E6E6E" border="true" borderColor="#D8D8D8" backgroundFill="true" backgroundColor="#000000" maxChars="50">
 * <defaultText>
 * <![CDATA[ Your Name : ]]>
 * </defaultText>
 * <!-- NAME FIELD TITLE -->
 * </namefield>
 * <emailfield x="18" y="68" width="360" height="30" font="Helvetica" size="20" color="#6E6E6E" border="true" borderColor="#D8D8D8" backgroundFill="true" backgroundColor="#000000" maxChars="50">
 * <defaultText>
 * <![CDATA[ E-mail Address : ]]>
 * </defaultText>
 * <!-- EMAIL FIELD TEXT -->
 * </emailfield>
 * <cardnumberfield x="18" y="118" width="250" height="30" font="Helvetica" size="20" color="#6E6E6E" border="true" borderColor="#D8D8D8" backgroundFill="true" backgroundColor="#000000" maxChars="20">
 * <defaultText>
 * <![CDATA[ Card Number : ]]>
 * </defaultText>
 * <!-- CARD NUMBER FIELD TEXT -->
 * </cardnumberfield>
 * <cvcfield x="278" y="118" width="100" height="30" font="Helvetica" size="20" color="#6E6E6E" border="true" borderColor="#D8D8D8" backgroundFill="true" backgroundColor="#000000" maxChars="3">
 * <defaultText>
 * <![CDATA[ CVC : ]]>
 * </defaultText>
 * <!-- CVC FIELD TEXT -->
 * </cvcfield>
 * <expirationmonthfield x="18" y="168" width="160" height="30" font="Helvetica" size="20" color="#6E6E6E" border="true" borderColor="#D8D8D8" backgroundFill="true" backgroundColor="#000000" maxChars="2">
 * <defaultText>
 * <![CDATA[ Expiry Month: ]]>
 * </defaultText>
 * <!-- EXPIRY MONTH FIELD TEXT -->
 * </expirationmonthfield>
 * <expirationyearfield x="218" y="168" width="160" height="30" font="Helvetica" size="20" color="#6E6E6E" border="true" borderColor="#D8D8D8" backgroundFill="true" backgroundColor="#000000" maxChars="4">
 * <defaultText>
 * <![CDATA[ Expiry Year: ]]>
 * </defaultText>
 * <!-- EXPIRY YEAR FIELD TEXT -->
 * </expirationyearfield>
 * <button x="100" y="208">
 * <!-- BUTTON STRIPE SUBMIT -->
 * <source>img/stripe-btn-submit.png</source>
 * </button>
 * </CTAStripe>
 * <p/>
 * }
 */
@XmlRootElement(name = "CTAConnect")
@XmlAccessorType(XmlAccessType.FIELD)
public class CTAStripeConfig {
    @XmlAttribute
    private int amount;
    @XmlAttribute
    private String currency;

    @XmlElement
    private ElementWithDefaultText namefield;
    @XmlElement
    private ElementWithDefaultText emailfield;
    @XmlElement
    private ElementWithDefaultText cardnumberfield;
    @XmlElement
    private ElementWithDefaultText cvcfield;
    @XmlElement
    private ElementWithDefaultText expirationmonthfield;
    @XmlElement
    private ElementWithDefaultText expirationyearfield;
    @XmlElement

    private ElementWithXYAttrAndSource button;

    public ElementWithDefaultText getExpirationyearfield() {
        return expirationyearfield;
    }

    public void setExpirationyearfield(ElementWithDefaultText expirationyearfield) {
        this.expirationyearfield = expirationyearfield;
    }

    public ElementWithDefaultText getExpirationmonthfield() {
        return expirationmonthfield;
    }

    public void setExpirationmonthfield(ElementWithDefaultText expirationmonthfield) {
        this.expirationmonthfield = expirationmonthfield;
    }

    public ElementWithDefaultText getCvcfield() {
        return cvcfield;
    }

    public void setCvcfield(ElementWithDefaultText cvcfield) {
        this.cvcfield = cvcfield;
    }

    public ElementWithDefaultText getCardnumberfield() {
        return cardnumberfield;
    }

    public void setCardnumberfield(ElementWithDefaultText cardnumberfield) {
        this.cardnumberfield = cardnumberfield;
    }

    public ElementWithDefaultText getEmailfield() {
        return emailfield;
    }

    public void setEmailfield(ElementWithDefaultText emailfield) {
        this.emailfield = emailfield;
    }

    public ElementWithDefaultText getNamefield() {
        return namefield;
    }

    public void setNamefield(ElementWithDefaultText namefield) {
        this.namefield = namefield;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ElementWithXYAttrAndSource getButton() {
        return button;
    }

    public void setButton(ElementWithXYAttrAndSource button) {
        this.button = button;
    }
}
