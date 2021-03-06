from django.conf.urls import url
from Restuarant import views

urlpatterns=[
    url(r'^user$',views.usersApi),
    url(r'^user/(?P<id>[0-9]+)$',views.usersApi),

    url(r'^order$',views.ordersApi),
    url(r'^order/(?P<id>[0-9]+)$',views.ordersApi),

    url(r'^loyalty$',views.loyaltyApi),
    url(r'^loyalty/(?P<id>[0-9]+)$',views.loyaltyApi),

    url(r'^menu$',views.menuApi),
    url(r'^menu/(?P<id>[0-9]+)$',views.menuApi),

    url(r'^employeesalary$',views.employeesalaryApi),
    url(r'^employeesalary/(?P<id>[0-9]+)$',views.employeesalaryApi),

    url(r'^orderlineitem$',views.orderlineitemsApi),
    url(r'^orderlineitem/(?P<id>[0-9]+)$',views.orderlineitemsApi),

    url(r'^menuitem$',views.menuitemApi),
    url(r'^menuitem/(?P<id>[0-9]+)$',views.menuitemApi),
    
    url(r'^stockitems$',views.stockitemsApi),
    url(r'^stockitem/(?P<id>[0-9]+)$',views.stockitemsApi),
]