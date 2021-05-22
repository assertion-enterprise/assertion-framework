package za.co.assertion.framework.config.cache;

import java.io.Serializable;
import java.util.Arrays;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author Ntsika Mark Mngoma
 * @created at 13:14:03 on 27 Apr 2021
 */
public class PrefixedSimpleKey implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final String prefix;
    private final Object[] params;
    private final String methodName;
    private int hashCode;

    /**
     * <p>Constructor for {@link PrefixedSimpleKey}.</p>
     * 
     * @param prefix {@link java.lang.String} object.
     * @param methodName {@link java.lang.String} object.
     * @param elements {@link java.lang.Object} object.
     */
    public PrefixedSimpleKey(String prefix, String methodName, Object... elements) {
        Assert.notNull(prefix, "Prefix must not be null");
        Assert.notNull(elements, "Elements must not be null");
        this.prefix = prefix;
        this.methodName = methodName;
        this.params = new Object[elements.length];
        System.arraycopy(elements, 0, this.params, 0, elements.length);
        this.hashCode = prefix.hashCode();
        this.hashCode = 31 * this.hashCode + methodName.hashCode();
        this.hashCode = 31 * this.hashCode + Arrays.deepHashCode(this.params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof PrefixedSimpleKey && this.prefix.equals(((PrefixedSimpleKey) other).prefix)
                && this.methodName.equals(((PrefixedSimpleKey) other).methodName)
                && Arrays.deepEquals(this.params, ((PrefixedSimpleKey) other).params)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        return this.hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.prefix + " " + getClass().getSimpleName() + this.methodName + " [" + StringUtils.arrayToCommaDelimitedString(this.params) + "]";
    }
}
