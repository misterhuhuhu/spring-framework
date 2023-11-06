package collection;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Gebruiker on 5/18/2018.
 */

@PropertySource("classpath:application.yaml")
public class CollectionsBean {

    @Resource
    private List<String> nameList;

    private Set<String> nameSet;

    private Map<Integer, String> nameMap;

    @Resource
    @Qualifier("CollectionsBean")
    private List<BaeldungBean> beanList = new ArrayList<>();

    
    @Value("${config:#{null}}")
    private List<String> nameListWithDefaultValue;
    
    public CollectionsBean() {
    }
    
    public List<String> getNameList() {
        return nameList;
    }
    
    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
    
    public Set<String> getNameSet() {
        return nameSet;
    }
    
    public void setNameSet(Set<String> nameSet) {
        this.nameSet = nameSet;
    }
    
    public Map<Integer, String> getNameMap() {
        return nameMap;
    }
    
    public List<BaeldungBean> getBeanList() {
        return beanList;
    }
    
    public void setBeanList(List<BaeldungBean> beanList) {
        this.beanList = beanList;
    }
    
    public List<String> getNameListWithDefaultValue() {
        return nameListWithDefaultValue;
    }
    
    public void setNameListWithDefaultValue(List<String> nameListWithDefaultValue) {
        this.nameListWithDefaultValue = nameListWithDefaultValue;
    }
    
    public CollectionsBean(Set<String> strings) {
        this.nameSet = strings;
    }

    @Resource
    public void setNameMap(Map<Integer, String> nameMap) {
        this.nameMap = nameMap;
    }

    public void printNameList() {
        System.out.println(nameList);
    }

    public void printNameSet() {
        System.out.println(nameSet);
    }

    public void printNameMap() {
        System.out.println(nameMap);
    }

    public void printBeanList() {
        System.out.println(beanList);
    }
    
    public void printNameListWithDefaults() {
        System.out.println(nameListWithDefaultValue);
    }
}
