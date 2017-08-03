package frame.menu;

import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.JOptionPane;

import main.Main;
import tasks.Task;

class Menu1_Tasks extends MenuHandler {
	
	@Override
	public String name() {
		return "Tasks";
	}

	@Override
	public ArrayList<MenuHandler> getItems() {
		ArrayList<MenuHandler> list = new ArrayList<>();
		
		ArrayList<String> categories = new ArrayList<>();
		
		for (int i = 0; i < Task.tasks.size(); i++) {
			final Task currentTask = Task.tasks.get(i);
			
			if (currentTask.menuCategory() == null) {
				continue;
			}
			
			for (int j = 0; j < currentTask.menuCategory().length; j++) {
				boolean isNew = true;

				for (int k = 0; k < categories.size(); k++) {
					if (categories.get(k).equalsIgnoreCase(currentTask.menuCategory()[j])) {
						isNew = false;
					}
				}
				
				if (isNew) {
					categories.add(currentTask.menuCategory()[j]);
					list.add(getCategories(currentTask, categories.get(categories.size() - 1)));
				}
			}
			
		}
		
		return list;
	}

	@Override
	public void action() {
		
	}
	
	private static MenuHandler getCategories(Task currentTask, String category) {
		
		MenuHandler menuHandler = new MenuHandler() {
			@Override
			public String name() {
				return category;
			}
			
			@Override
			public ArrayList<MenuHandler> getItems() {
				ArrayList<MenuHandler> list = new ArrayList<>();
				
				for (int i = 0; i < Task.tasks.size(); i++) {
					final Task currentTask = Task.tasks.get(i);
					
					if (currentTask.menuCategory() == null) {
						continue;
					}
					
					for (int j = 0; j < currentTask.menuCategory().length; j++) {
						if (currentTask.menuCategory()[j].equalsIgnoreCase(category)) {
							int[] parametersindex;
							
							if (currentTask.parameters() != null) {
								parametersindex = new int[currentTask.parameters().size()];
								
								for (int k = 0; k < parametersindex.length; k++) {
									parametersindex[k] = -1;
								}
							} else {
								parametersindex = null;
							}
							
							list.add(getTasks(currentTask, currentTask.name(), new ArrayList<>(), parametersindex));
						}
					}
				}
				
				return list;
			}
			
			@Override
			public void action() {
			}
		};
		
		return menuHandler;
	}
	
	private static MenuHandler getTasks(Task currentTask, String name, ArrayList<Integer> forbitten, int[] parametersindex) {
		MenuHandler menuHander = new MenuHandler() {
			
			@Override
			public String name() {
				return name;
			}
			
			@Override
			public ArrayList<MenuHandler> getItems() {
				ArrayList<MenuHandler> list = new ArrayList<>();
				
				if (currentTask.parameters() != null) {
					for (int i = 0; i < currentTask.parameters().size(); i++) {
						boolean allowed = true;
						
						for (int j = 0; j < forbitten.size(); j++) {
							if (i == forbitten.get(j)) {
								allowed = false;
							}
						}
						
						if (!allowed) {
							continue;
						}
						
						String[] parameters = currentTask.parameters().get(i);
						for (int j = 0; j < parameters.length; j++) {
							ArrayList<Integer> forbitten_ = new ArrayList<>();
							forbitten_.addAll(forbitten);
							forbitten_.add(i);
							
							int[] parametersindex_ = parametersindex;
							parametersindex_[i] = j;
							
							list.add(getTasks(currentTask, parameters[j], forbitten_, parametersindex_));
						}
					}
				}
				
				if (list.size() > 0) {
					list.add(new Separator());
				}
				
				list.add(getInsertItem(currentTask, parametersindex));
				list.add(getDescription(currentTask));

				return list;
			}
			
			@Override
			public void action() {
				
			}
		};
		
		return menuHander;
	}
	
	private static MenuHandler getInsertItem(Task currentTask, int[] parametersindex) {
		MenuHandler menuHandler = new MenuHandler() {
			
			@Override
			public String name() {
				return "Insert";
			}
			
			@Override
			public ArrayList<MenuHandler> getItems() {
				return null;
			}
			
			@Override
			public void action() {
				String s = "";
				
				s += currentTask.name().toLowerCase();
				
				if (parametersindex != null) {
					for (int i = 0; i < parametersindex.length; i++) {
						if (parametersindex[i] >= 0) {
							s += " " + currentTask.parameters().get(i)[parametersindex[i]];
						}
					}
				}
				
				// TODO:
				// Main.frame.generator.addTask(s);
			}
		};
		
		return menuHandler;
	}
	
	private static MenuHandler getDescription(Task currentTask) {
		MenuHandler menuHandler = new MenuHandler() {
			
			@Override
			public String name() {
				return "Help";
			}
			
			@Override
			public ArrayList<MenuHandler> getItems() {
				return null;
			}
			
			@Override
			public void action() {
				JOptionPane.showMessageDialog(null, currentTask.getDesciption(), currentTask.name(), JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		return menuHandler;
	}
	
}
