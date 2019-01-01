package phylogenetic_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author badys
 */
public class TreeNode {

    private List<TreeNode> children = new ArrayList<TreeNode>();
    private TreeNode parent = null;
    private float weight = 0;
    private String name = "";
    private String rawFormat = "";

    public TreeNode() {
    }

    public TreeNode(TreeNode node) {
        this.children = node.children.stream().map(child -> new TreeNode(child)).collect(Collectors.toList());
        this.children.forEach(child -> child.setParent(this));
        this.parent = node.parent;
        this.weight = node.weight;
        this.name = node.name;
        this.rawFormat = node.rawFormat;
    }

    public TreeNode(String name) {
        int idx = name.indexOf(':');
        if (idx == -1) {
            this.name = name;
            weight = 0;
        } else {
            this.name = name.substring(0, idx);
            weight = Float.parseFloat(name.substring(idx + 1, name.length()));
        }
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChildren(List<TreeNode> children) {
        children.forEach(this::addChild);
    }

    /*
     * getters and setters
     */
    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public float getDistanceToParent() {
        return weight;
    }

    public void setDistanceToParent(float distanceToParent) {
        this.weight = distanceToParent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRawFormat() {
        return rawFormat;
    }

    public void setRawFormat(String rawFormat) {
        this.rawFormat = rawFormat;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    

}
