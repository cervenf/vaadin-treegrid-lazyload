package com.example.application.views.about;

import com.example.application.backend.dto.TreeNode;
import com.example.application.views.MainLayout;
import com.example.application.views.TreeGridBackendDataProvider;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Tree grid")
@Route(value = "tree grid", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class TreeGridView extends VerticalLayout {

    private final TreeGrid<TreeNode> treeGrid;

    public TreeGridView(TreeGridBackendDataProvider treeGridBackendDataProvider) {
        treeGrid = new TreeGrid<>();
        treeGrid.setDataProvider(treeGridBackendDataProvider);
        treeGrid.setHeightFull();
        treeGrid.addHierarchyColumn(TreeNode::getName).setHeader("Name");
//        .setAutoWidth(true);
        add(treeGrid);

        setSizeFull();
    }

}
