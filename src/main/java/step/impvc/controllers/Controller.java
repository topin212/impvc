package step.impvc.controllers;

import step.impvc.models.Model;
import step.impvc.observing.Actions;
import step.impvc.views.View;

/**
 *
 * created May 30, 2017
 */
public interface Controller {
    void updateModel(Model model, Actions action, Object[] args);
}
