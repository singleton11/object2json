package com.github.singleton11.interactor.java

import com.github.singleton11.interactor.ClassMethodInteractor
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiRecursiveElementWalkingVisitor

class JavaClassMethodInteractor(private val psiElement: PsiElement) : ClassMethodInteractor {
    override fun getMethods(): List<PsiElement> {
        var classFound = false

        val methodList = mutableListOf<PsiElement>()

        psiElement.accept(object : PsiRecursiveElementWalkingVisitor() {
            override fun visitElement(element: PsiElement) {

                if (!classFound && element !is PsiClass) {
                    super.visitElement(element)
                }

                if (element is PsiClass && !classFound) {
                    classFound = true
                    super.visitElement(element)
                }

                if (element is PsiMethod) {
                    methodList.add(element)
                }
            }
        })

        return methodList
    }
}