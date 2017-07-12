package com.amber.random.datapoliceuk.viewmodel;

import com.amber.random.datapoliceuk.model.force.ForceItem;

import java.util.List;

/**
 * Created by akhlivnyuk on 7/11/2017.
 */

public interface ForcesListFragmentView extends IView {
    void load(List<ForceItem> forces);
    void onClick(ForceItem forceItem);
}
