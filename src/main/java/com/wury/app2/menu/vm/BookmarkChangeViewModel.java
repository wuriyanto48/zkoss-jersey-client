package com.wury.app2.menu.vm;

import java.util.Collections;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;

import com.wury.app2.menu.model.SidebarPage;
import com.wury.app2.menu.service.SidebarPageConfig;
import com.wury.app2.menu.service.SidebarPageConfigAjaxImpl;

public class BookmarkChangeViewModel {

	//todo: wire service
		private SidebarPageConfig pageConfig = new SidebarPageConfigAjaxImpl();
		
		@Command("onBookmarkNavigate")
		public void onBookmarkNavigate(@BindingParam("bookmark") String bookmark) {
			if(bookmark.startsWith("p_")){
				//retrieve page from config
				String p = bookmark.substring("p_".length());
				SidebarPage page = pageConfig.getPage(p);
				if(page!=null) {
					//and post command to NavigationViewModel
					BindUtils.postGlobalCommand(null,  null, "onNavigate", Collections.<String, Object>singletonMap("page", page));
				}
			}
		}
}
