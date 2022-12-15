# Map Timestamp with Time Zone column
* Use `columnDefinition` attribute in `Column` annotation
```
@Column(name = "run_from", columnDefinition= "TIMESTAMP WITH TIME ZONE")
@NotNull
@Temporal(TemporalType.TIMESTAMP)
private Date runFrom;
```
* We can use `not null` also like below
```
@Column(name = "run_from", columnDefinition = "timestamp with time zone not null")
@NotNull
@Temporal(TemporalType.TIMESTAMP)
private Date runFrom;
```
------
# Mapping XML type
* This Java class can be used to enable Hibernate to store and retrieve PostgreSQL "xml" typed fields as String objects. It's trivially adapted to parse the XML into a DOM and store from a DOM or whatever your preferred XML representation instead.
* To tell Hibernate to use this UserType for a given mapped field, specify a Type annotation on the property, like:
```
@org.hibernate.annotations.Type(type="foo.bar.SQLXMLType")
private String markup;
```
* If you're using Hibernate's XML mapping, add a "type" attribute to the "property" mapping, and specify the fully-qualified name of the type in the value. See, eg, this article.
* Here's the source to the UserType. Feel free to adapt it as necessary. Be aware, though, that if you change the Java type in use to something that's mutable (ie where you can change the state of an instance) you must significantly adapt the implementation below according to the API documentation here.
* Without using a UserType like this, you'll be able to retrieve xml columns fine, but on storing changes you'll receive a PostgreSQL error like:
```
ERROR:  column "markup" is of type xml but expression is of type character varying at character 122
```
* SQLXMLType class
```
package foo.bar;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;

/**
 * Store and retrieve a PostgreSQL "xml" column as a Java string.
 */
public class SQLXMLType implements org.hibernate.usertype.UserType {

    private final int[] sqlTypesSupported = new int[] { Types.VARCHAR };

    @Override
    public int[] sqlTypes() {
        return sqlTypesSupported;
    }

    @Override
    public Class returnedClass() {
        return String.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == null) {
            return y == null;
        } else {
            return x.equals(y);
        }
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x == null ? null : x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
        assert(names.length == 1);
        String xmldoc = rs.getString( names[0] );
        return rs.wasNull() ? null : xmldoc;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            st.setObject(index, value, Types.OTHER);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null)
            return null;
        return new String( (String)value );
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (String) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return (String) cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
```
