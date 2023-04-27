package com.example.application.views;

import com.example.application.backend.dto.TreeNode;
import com.vaadin.flow.data.provider.hierarchy.AbstractBackEndHierarchicalDataProvider;
import com.vaadin.flow.data.provider.hierarchy.HierarchicalQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static com.vaadin.flow.spring.data.VaadinSpringDataHelpers.toSpringPageRequest;


@RequiredArgsConstructor
@Service
public class TreeGridBackendDataProvider extends AbstractBackEndHierarchicalDataProvider<TreeNode, Void> {

    private final transient DataProviderService dataProviderService;

    @Override
    protected Stream<TreeNode> fetchChildrenFromBackEnd(HierarchicalQuery<TreeNode, Void> query) {
        var treeNode = query.getParent();
        if (treeNode == null) {
            return dataProviderService.getAllTeachers(toSpringPageRequest(query));
        }

        if ("teacher".equalsIgnoreCase(treeNode.getNodeType())) {
            return dataProviderService.getStudentsByTeacher(treeNode.getId()).stream();
        }
        return Stream.empty();
    }

    @Override
    public boolean hasChildren(TreeNode treeNode) {
        if (treeNode == null || "teacher".equalsIgnoreCase(treeNode.getNodeType())) {
            return true;
        }
        return false;
    }

    @Override
    public int getChildCount(HierarchicalQuery<TreeNode, Void> query) {
        var treeNode = query.getParent();

        if (treeNode == null) {
            return dataProviderService.getTeacherCount();
        }
        if ("teacher".equalsIgnoreCase(treeNode.getNodeType())) {
            return dataProviderService.getStudentsByTeacher(treeNode.getId()).size();
        }
        return 0;
    }

}
