package com.smokejumperit.json.parser

class JSONParserTest extends GroovyTestCase {

	
	void testParseObjectSimple() {
		def str = """
			{
				foo: 'foo',
				bar: 2,
				baz: false,
				blarg: null
			}
		"""
		def map = new JSONParser(str).parseObject()
		assertNotNull(map)
		assertEquals('foo', map.foo)
		assertEquals(2, map.bar)
		assertEquals(false, map.baz)
		assertEquals(null, map.blarg)
	}

	void testParseArraySimple() {
		def str = """
			[	
				'foo',
				2,
				false,
				null
			]
		"""
		def ary = new JSONParser(str).parseArray()
		assertNotNull(ary)
		assertEquals('foo', ary[0])
		assertEquals(2, ary[1])
		assertEquals(false, ary[2])
		assertEquals(null, ary[3])
	}

	void testParseAnything() {
		[
		"""
			[	
				'foo',
				2,
				false,
				null
			]
		""","""
			{
				foo: 'foo',
				bar: 2,
				baz: false,
				blarg: null
			}
		"""
		].each { String str ->
			new JSONParser(str).parse()
		}
	}

	void testComments() {
		new JSONParser("""
			// Starting comment
			[
				1 # Internal Comment
				,
				2
			]	
			/* Ending comment
			*/
		"""
		).parseArray()
	}

}
