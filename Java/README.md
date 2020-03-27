# Notes

## Configuation in Mircoservices

Removing "Setting"  from complied code
Change runtime behavior 
Enforce Consistency accross slastic services
Cache values to reduced load on databases



## Xml Serilizer
XmlMapper xmlMapper = new XmlMapper();
xmlMapper.writeValue(new File("string.xml"), extractedDocument.getLineBlocks().stream().map(block -> block.getText()).collect(Collectors.toList()));
