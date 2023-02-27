package org.antlr.v4.codegen.target;

import org.antlr.v4.codegen.CodeGenerator;
import org.antlr.v4.codegen.Target;
import org.stringtemplate.v4.STGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RubyTarget extends Target {

	private static final ThreadLocal<STGroup> targetTemplates = new ThreadLocal<STGroup>();

	protected static final HashSet<String> reservedWords = new HashSet<>(Arrays.asList(
			"abstract", "assert", "boolean", "break", "byte", "case", "catch",
			"char", "class", "const", "continue", "default", "do", "double", "else",
			"enum", "extends", "false", "final", "finally", "float", "for", "goto",
			"if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "null", "package", "private", "protected",
			"public", "return", "short", "static", "strictfp", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "true", "try",
			"void", "volatile", "while",

			// misc
			"rule", "parserRule"
	));

	public RubyTarget(CodeGenerator gen) { super(gen); }

	@Override
	public Set<String> getReservedWords() { return reservedWords; }

	@Override
	public int getSerializedATNSegmentLimit() {
		// 65535 is the class file format byte limit for a UTF-8 encoded string literal
		// 3 is the maximum number of bytes it takes to encode a value in the range 0-0xFFFF
		return 65535 / 3;
	}



	@Override
	public boolean isATNSerializedAsInts() {
		return true;
	}
}
