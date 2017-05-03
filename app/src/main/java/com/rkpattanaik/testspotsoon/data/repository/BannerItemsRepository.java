package com.rkpattanaik.testspotsoon.data.repository;

import com.rkpattanaik.testspotsoon.R;
import com.rkpattanaik.testspotsoon.data.model.BannerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajesh Pattanaik
 */

public class BannerItemsRepository {
    private List<BannerItem> bannerItems;

    public BannerItemsRepository() {
        initBannerItemsList();
    }

    private void initBannerItemsList() {
        bannerItems = new ArrayList<>();

        BannerItem item1 = new BannerItem(
                R.drawable.banner_half_girlfriend,
                "Half Girlfriend (2017)",
                "Arjun Kapoor, Shraddha Kapoor"
        );
        bannerItems.add(item1);

        BannerItem item2 = new BannerItem(
                R.drawable.banner_raabta,
                "Raabta (2017)",
                "Sushant Singh Rajput, Kriti Shanon"
        );
        bannerItems.add(item2);

        BannerItem item3 = new BannerItem(
                R.drawable.banner_meri_pyaari_bindu,
                "Meri Pyaari Bindu (2017)",
                "Ayshmann Khurrana, Parineeti Chopra"
        );
        bannerItems.add(item3);
    }

    public List<BannerItem> getBannerItems() {
        return bannerItems;
    }
}
