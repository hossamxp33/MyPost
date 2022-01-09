package com.tarweej.mypost.entites.home

data class MainDataModel(
    var CustomerFamouse: List<CustomerFamouse>,
    var bestFamouse: List<BestFamouse>,
    var certifiedFamouse: List<CertifiedFamouse>,
    var products: List<Product>,
    var sliders: List<Slider>,
    var specialFamouse: List<SpecialFamouse>
)