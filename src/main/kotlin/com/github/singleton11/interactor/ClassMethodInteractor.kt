package com.github.singleton11.interactor

import com.intellij.psi.PsiElement

interface ClassMethodInteractor {
    fun getMethods(): List<PsiElement>
}