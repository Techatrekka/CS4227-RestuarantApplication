# Generated by Django 3.2.9 on 2021-11-13 16:24

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Restuarant', '0023_alter_employeesalary_user_id'),
    ]

    operations = [
        migrations.AlterField(
            model_name='employeesalary',
            name='salary',
            field=models.IntegerField(),
        ),
    ]
