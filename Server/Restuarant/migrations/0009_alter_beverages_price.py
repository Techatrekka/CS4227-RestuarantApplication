# Generated by Django 3.2.9 on 2021-11-09 12:41

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Restuarant', '0008_remove_beverages_description'),
    ]

    operations = [
        migrations.AlterField(
            model_name='beverages',
            name='price',
            field=models.DecimalField(decimal_places=2, max_digits=3),
        ),
    ]
