package com.lbb.dota

/**
 * 根据CSV表头数据生成CS代码.
 */
class Csv2Cs2 {
    
    static final String namespace = "HXFS.Config"
	static int numProto = 100;
	
    static void generate(String className, List<ColumnInfo> columns, File javaFile) {
        // 过滤掉server字段
        columns = columns.findAll { (it.useType == 1 || it.useType == 2) }
		
		// 先过滤client会被重写的列
		List<ColumnInfo> columns1 = columns.findAll { it.clientType == 1}
		boolean isDerived = (columns1.size() < columns.size());
        
        javaFile.withWriter("utf-8") { writer ->
            writer.println "// Generated by tool, DO NOT modify!"
			writer.println "using ProtoBuf;"
            writer.println "namespace ${namespace}"
            writer.println "{"
			writer.println "  [ProtoContract]"
			if (isDerived) {
				String derivedClass = className.substring(0, className.size()-3) + "Config";
				writer.println "  [ProtoInclude(${numProto++}, typeof(${derivedClass}))]"
			}
            writer.println "  public class ${className} : CfgBase"
            writer.println "  {"

            // constructor
            writer.println("    public ${className}() {}")
            writer.println ""
            
            // properties
			int columnIndex = 1;
            columns1.each { column ->
                def override = column.csFieldName == 'Id' ? 'override ' : ''
                def fieldType = column.csFieldType
                def fieldName = column.csFieldName
                def comment = column.desc
				writer.println "    [ProtoMember(${columnIndex++})]"
				writer.println "    public ${override}${fieldType} ${fieldName} { get; set; } // ${comment}"
            }

            writer.println "  }" // end class
            writer.println "}" // end namespace
        }
    }
    
}
