package org.antlr.v4.codegen.target;

import org.antlr.v4.codegen.CodeGenerator;
import org.antlr.v4.codegen.Target;
import org.stringtemplate.v4.STGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RubyTarget extends Target {

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

	// 使用 ' ，只需要转义 ' 和 \

	@Override
	public Set<String> getReservedWords() { return reservedWords; }


	@Override
	public boolean isATNSerializedAsInts() {
		return true;
	}
}
