package com.github.singleton11

import com.github.singleton11.interactor.java.JavaClassMethodInteractor
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys

class MainAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val psiFile = e.getData(LangDataKeys.PSI_FILE)

        psiFile?.let {
            val methods = JavaClassMethodInteractor(it).getMethods()
            println(methods)
        }

    }
}