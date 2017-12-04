package gen.api.mvc;

import java.io.File;

import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.elements.BaseElements;
import gen.api.mvc.elements.ClassElements;

public class App 
{
    public static void main( String[] args ) throws Exception {
        JCodeModel model = new JCodeModel();
        JPackage pkg = BaseElements.getPackage(model, "samplePackage");
        JDefinedClass cls = BaseElements.getClass(pkg, "SampleClass");
        JFieldVar fld = BaseElements.getField(cls, "field1", int.class, JMod.PRIVATE);
        ClassElements.getGetter(cls, fld);
        ClassElements.getSetter(cls, fld);
        model.build(new File("/"), System.out);
    }
}
