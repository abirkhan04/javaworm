import { Rule, SchematicContext, Tree, url, apply, template, mergeWith, SchematicsException, move } from '@angular-devkit/schematics';
import { getWorkspace } from '@schematics/angular/utility/config';
// import { parseName} from '@schematics/angular/utility/parse-name';
// import { buildDefaultPath} from '@schematics/angular/utility/project';
import { join, normalize } from 'path';
import { strings } from '@angular-devkit/core';

export function setupOptions(host: Tree, options: any): Tree {
  const workspace = getWorkspace(host);
  if (!options.project) {
    options.project = Object.keys(workspace.projects)[0];
  }
  const project = workspace.projects[options.project];
  options.path = join(normalize(project.root), 'src');
  return host;
}


export function testComponent(_options: Schema): Rule {
  return (tree: Tree, _context: SchematicContext) => {
    // const { name } = _options;
    // tree.create('hello.js', `console.log('Hello ${name}!')`);
    const workspaceConfigurationBuffer = tree.read("angular.json");
    if(!workspaceConfigurationBuffer) {
      throw new SchematicsException("Not an Angular CLI workspace");
    }
    const workspaceConfiguration = JSON.parse(workspaceConfigurationBuffer.toString());
    const project =  workspaceConfiguration.projects.Test;
    const projectType = project.projectType === 'application' ? 'app' : 'libs';

    if (_options.path === undefined) {
      _options.path = `${project.sourceRoot}/${projectType}`;
    }
    // const defaultProjectPath = buildDefaultPath(project);
    //const parsedPath = parseName(defaultProjectPath, _options.project);
    // const { path } = parsedPath;
    const sourceTemplates = url('./files');
    const sourceParameterizedTemplates = apply(sourceTemplates, [
      template({
        ..._options,
        ...strings,
      }),
      move(normalize(_options.path as string))
    ]);
    return mergeWith(sourceParameterizedTemplates)(tree, _context);
  };
}

export interface Schema {
  name: string;
  project: string;
  path: string;
}
