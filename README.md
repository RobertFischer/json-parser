JSON Parser
===========

This is a JavaCC-derived JSON parser. It is crazy fast and fault tolerant, but with no bells or whistles.  The intent is for this to form the backbone for other JSON-consuming libraries like [Resty](http://github.com/RobertFischer/Resty).

Faults Tolerated
-----------------

None of the following is legitimate JSON code, yet you will find it in the wild. This library parses them
'correctly' (at least, insofar as standards-violating processing can be 'correct').

* *C-style and SH-style Comments* - e.g. `/* ... */`, `// ...`, `# ...`

* *Bareword Keys* - Yup, that's invalid JSON. For reals.

* *Large Numerical Value Support* - Not technically a fault, but most libraries parse integers and decimals using doubles or longs, which can be a problem if you have large values in your JSON. This library uses `BigDecimal` and `BigInteger` by default for more accurate parsing. You can shift to using double and long values by setting the `parser.nativeNumbers` property, but if you are thinking about setting that flag for performance reasons, you're almost certainly doing it wrong.

Usage
--------

Here's a minimal example:

```java
import com.smokejumperit.json.parser.JSONParser

public class Foo {
	public static void main(String[] args) {
		System.out.println("Parsed value: " + new JSONParser(args[0]).parse());
	}
}
```

Also available on the `JSONParser` type: 

* **`**InputStream**` and `**Reader**` constructors** - For your consuming convenience
* `**parseObject()**` - Parses a JSON object into a `LinkedHashMap`
* `**parseArray()**` - Parses a JSON array into an `ArrayList`

License
---------

<p xmlns:dct="http://purl.org/dc/terms/" xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#">
  <a rel="license"
     href="http://creativecommons.org/publicdomain/zero/1.0/">
    <img src="http://i.creativecommons.org/p/zero/1.0/88x31.png" style="border-style: none;" alt="CC0" />
  </a>
  <br />
  To the extent possible under law,
  <a rel="dct:publisher"
     href="http://smokejumperit.com/">
    <span property="dct:title">Robert Fischer</span></a>
  has waived all copyright and related or neighboring rights to
  <span property="dct:title">JSON Parser</span>.
This work is published from:
<span property="vcard:Country" datatype="dct:ISO3166"
      content="US" about="http://smokejumperit.com/">
  United States</span>.
</p>
