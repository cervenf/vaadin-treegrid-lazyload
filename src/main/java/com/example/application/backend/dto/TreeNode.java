package com.example.application.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


//@AllArgsConstructor
@Getter
@Setter
public class TreeNode implements Serializable {
    private Long id;
    private String name;
    private String nodeType;


    public TreeNode(Long id, String name, String nodeType) {
        this.id = id;
        this.name = name;
        this.nodeType = nodeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(id, treeNode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
